package codeVisualizer.controller;

import codeVisualizer.dto.CodeRequest;
import codeVisualizer.dto.ParseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codeVisualizer.service.CodeParserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Enable CORS for development
public class CodeController {

    private final CodeParserService parserService;

    @Autowired
    public CodeController(CodeParserService parserService) {
        this.parserService = parserService;
    }

    @PostMapping("/parse")
    public ResponseEntity<ParseResponse> parseCode(@RequestBody CodeRequest request) {
        try {
            ParseResponse response = parserService.parseCode(request.getCode());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new ParseResponse(null, "Error parsing code: " + e.getMessage())
            );
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is running");
    }
}