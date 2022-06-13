package Blog.controller;


import Blog.model.Post;
import Blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.Optional;

@Controller
@SessionAttributes("post")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("/showNewPostForm")
    public String showNewPostForm(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "new_post";
      }

      @PostMapping("/savePost")
      public String savePost(@ModelAttribute("post") Post post){
        postService.savePost(post);
        return "redirect:/";
      }
    @GetMapping("/showPostForUpdate/{id}")
    public String showPostForUpdate(@PathVariable(value = "id") long id, Model model){
        //get post from Blog.service
        Post post = postService.getPostById(id);
        //set post as a Blog.model attribute to pre-populate the form
        model.addAttribute("post", post);
        return "update_post";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable(value = "id") Long id){
        this.postService.deletePostById(id);
        return "redirect:/";
    }

//Forgot to add a proper Get Method, here is that now
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model) {
 // get username of current logged in session user
// String authUsername = SecurityContextHolder.getContext().getAuthentication().getName();
// find post by id
        Optional<Post> optionalPost = Optional.ofNullable(this.postService.getPostById(id));
        // if post exist put it in Blog.model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
//            // Check if current logged in user is owner and let view template know to take according actions
//            if (authUsername.equals(post.getUser().getUsername())) {
//                Blog.model.addAttribute("isOwner", true);
//            }
            return "post";
        } else {
            return "404";
        }
    }


//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value = "pageNo")int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDir") String sortDir,
//                                Model Blog.model){
//        int pageSize = 5;
//        Page<Post> page = postService.findPaginated(pageNo, pageSize, sortField, sortDir);
//        List<Post> listPosts = page.getContent();
//        Blog.model.addAttribute("currentPage", pageNo);
//        Blog.model.addAttribute("totalPages", page.getTotalPages());
//        Blog.model.addAttribute("totalItems", page.getTotalElements());
//
//        Blog.model.addAttribute("sortField", sortField);
//        Blog.model.addAttribute("sortDir", sortDir);
//        Blog.model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc": "asc");
//
//        Blog.model.addAttribute("listPosts", listPosts);
//        return "index";
//    }
}
