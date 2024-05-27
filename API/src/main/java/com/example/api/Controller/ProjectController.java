package com.example.api.Controller;

import com.example.api.DTO.*;
import com.example.api.Entity.*;
import com.example.api.Exception.NotFoundException;
import com.example.api.Response.ApiResponse;
import com.example.api.Response.ResponseError;
import com.example.api.Response.ResponseMessage;
import com.example.api.Service.ProjectServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    ProjectServiceImpl projectServiceImpl;

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> getProjects() {
        List<ProjectDTO> projectDTOs = projectServiceImpl.getAllProjects();
        return ResponseEntity.ok(new ApiResponse<>("Lấy danh sách thành công", projectDTOs));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse<?>> getProjectById(@PathVariable String projectId) {
        ProjectDTO projectDTO = projectServiceImpl.getProjectById(projectId);
        if (projectDTO != null) {
            return ResponseEntity.ok(new ApiResponse<>("Lấy project thành công", projectDTO));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>("Tải project không thành công", new ResponseError("Không có project nào có id " + projectId)));
        }
    }

    @GetMapping(value = {"/auth"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> getProjectByUser(@RequestParam(required = false) List<String> status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();
            List<ProjectDTO> projectDTOs = projectServiceImpl.findProjectByUser(email, status);
            return ResponseEntity.ok(new ApiResponse<>("Lấy projects thành công", projectDTOs));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse<>("Lỗi", new ResponseMessage("Người dùng không tồn tại")));
        }
    }

    @GetMapping(value = {"/keyword"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> findByKeyWord(@RequestParam String keyWord) {
        List<ProjectDTO> projects = projectServiceImpl.findByKeyWord(keyWord);
        if (keyWord != null && !keyWord.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<List<ProjectDTO>>("Tìm kiếm thành công", projects));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse<ResponseError>("Tìm kiếm thất bại", new ResponseError("Không có nội dung thuộc " + keyWord)));
        }
    }

    @GetMapping(value = {"/censor"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> findByProjectCensor(@RequestParam(required = false) List<String> status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            String email = ((UserDetails) authentication.getPrincipal()).getUsername();
            List<ProjectDTO> projectDTOs = projectServiceImpl.findByProjectCensor(email, status);
            return ResponseEntity.ok(new ApiResponse<>("Lấy projects thành công", projectDTOs));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse<>("Lỗi", new ResponseMessage("Người dùng không tồn tại")));
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> createProject(@RequestBody ProjectRequestDTO projectRequestDTO) throws JsonProcessingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            String email = (((UserDetails) authentication.getPrincipal()).getUsername());
            ProjectDTO projectDTO = projectServiceImpl.createProject(projectRequestDTO, email);
            return ResponseEntity.ok(new ApiResponse<>("Tạo mới project thành công", projectDTO));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse<>("Lỗi", new ResponseMessage("Người dùng không tồn tại")));
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> updateProject(@RequestBody UpdateProjectDTO updateProjectDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            try {
                ProjectDTO projectDTO = projectServiceImpl.updateProject(updateProjectDTO);
                return ResponseEntity.ok(new ApiResponse<>("Cập nhật thành công", projectDTO));
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            return ResponseEntity.status(401).body(new ApiResponse<>("Lỗi", new ResponseMessage("Người dùng chưa được xác thực")));
        }
    }

    @PutMapping(value = {"/isPulic"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> UpdateisPublicProject(@RequestBody RequestDTO requestDTO) {

        ProjectDTO projectresult = projectServiceImpl.updateIsPublic(requestDTO);

        if (projectresult != null) {
            return ResponseEntity.ok(new ApiResponse<ProjectDTO>("Cập nhật sản phẩm thành công", projectresult));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse<ResponseError>("Cập nhật phẩm không thành công", new ResponseError("Sản phẩm chưa được cập nhật")));
        }

    }

    @PutMapping("/view")
    public ResponseEntity<ApiResponse<?>> updateView(@RequestBody UpdateViewDTO updateViewDTO) {
        ProjectDTO projectDTO = projectServiceImpl.updateView(updateViewDTO);
        return ResponseEntity.ok(new ApiResponse<>("Cập nhật view lượt xem thành công", projectDTO));
    }

    @DeleteMapping("/dlt")
    public ResponseEntity<ResponseMessage> deleteProjects(@RequestBody List<UUID> purchasesToDelete) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetails) {
            projectServiceImpl.deleteProjects(purchasesToDelete);
            return ResponseEntity.ok(new ResponseMessage("Xóa dự án thành công"));
        } else {
            return ResponseEntity.status(401).body(new ResponseMessage("Người dùng chưa được xác thực"));
        }
    }

    @DeleteMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> deleteProject(@RequestParam String projectId) {
        projectServiceImpl.getProjectDetailsById(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

//    @GetMapping(value = {"/report"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity FindByKeyWord(@RequestParam Date date) {
//        Integer count = projectServiceImpl.CountProject(date);
//        if (date != null) {
//            return ResponseEntity.ok("Tải thành công");
//        } else {
//            return ResponseEntity.badRequest().body("Tham số không hợp lệ");
//        }
//
//    }

    @GetMapping(value ={"/reportView"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> ReportView() {
        List<ReportDTO> reportDTO = projectServiceImpl.TopProjectWithView();
        if (reportDTO != null   ) {
            return ResponseEntity.ok(new ApiResponse<List<ReportDTO>>("Thành công", reportDTO));
        }
        else
            return ResponseEntity.badRequest().body(new ApiResponse<ResponseError>("Lỗi", new ResponseError("Sản phẩm chưa được cập nhật")));

    }
}
