package cc.wlizhi.wlizhitest.controller;

import cc.wlizhi.wlizhitest.model.base.PageQuery;
import cc.wlizhi.wlizhitest.model.base.PageResult;
import cc.wlizhi.wlizhitest.model.base.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "用户管理", description = "用户相关接口")
public class UserController {

    @GetMapping("/{id}")
    @Operation(summary = "获取用户信息", description = "根据ID获取用户详细信息")
    public Result<Map<String, Object>> getUserById(
            @Parameter(description = "用户ID") @PathVariable Long id) {
        
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("username", "user_" + id);
        user.put("email", "user" + id + "@example.com");
        user.put("createTime", Date.from(Instant.now()));
        
        return Result.ok(user);
    }

    @PostMapping("/page")
    @Operation(summary = "分页查询用户", description = "分页获取用户列表")
    public Result<PageResult<Map<String, Object>>> pageUsers(
            @RequestBody PageQuery pageQuery) {
        
        List<Map<String, Object>> userList = new ArrayList<>();
        for (int i = 1; i <= pageQuery.getPageSize(); i++) {
            Map<String, Object> user = new HashMap<>();
            user.put("id", (long) ((pageQuery.getPageIndex() - 1) * pageQuery.getPageSize() + i));
            user.put("username", "user_" + i);
            user.put("email", "user" + i + "@example.com");
            userList.add(user);
        }
        
        long total = 100L;
        int totalPages = (int) Math.ceil((double) total / pageQuery.getPageSize());
        
        PageResult<Map<String, Object>> pageResult = PageResult.of(
                pageQuery.getPageIndex(),
                pageQuery.getPageSize(),
                total,
                totalPages,
                userList
        );
        
        return Result.ok(pageResult);
    }

    @PostMapping
    @Operation(summary = "创建用户", description = "创建新用户")
    public Result<Long> createUser(
            @Parameter(description = "用户名", required = true) @RequestParam String username,
            @Parameter(description = "邮箱", required = true) @RequestParam String email) {
        
        Long userId = System.currentTimeMillis();
        
        return Result.ok(userId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新用户", description = "更新用户信息")
    public Result<Void> updateUser(
            @Parameter(description = "用户ID") @PathVariable Long id,
            @Parameter(description = "用户名") @RequestParam(required = false) String username,
            @Parameter(description = "邮箱") @RequestParam(required = false) String email) {
        
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户")
    public Result<Void> deleteUser(
            @Parameter(description = "用户ID") @PathVariable Long id) {
        
        return Result.ok();
    }
}
