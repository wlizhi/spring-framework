package cc.wlizhi.springbootdemo.controller;

import cc.wlizhi.springbootdemo.model.base.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
@Tag(name = "Demo接口", description = "示例接口")
public class DemoController {

	@GetMapping("/hello")
	@Operation(summary = "获取问候信息", description = "返回一个简单的问候消息")
	public Result<String> hello(@Parameter(description = "名称") @RequestParam(defaultValue = "World") String name) {
		return Result.ok("Hello, " + name + "!");
	}

	@PostMapping("/create")
	@Operation(summary = "创建示例", description = "创建一个新的示例对象")
	public Result<String> create(@Parameter(description = "示例名称", required = true) @RequestParam String exampleName) {
		return Result.ok("Created: " + exampleName);
	}
}
