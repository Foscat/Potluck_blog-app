package com.tts.PotluckAdventures.BlogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class BlogPostController {

	/**
	 * Route annotation:
	 * POST - @PostMapping
	 * GET - @RequestMpping, @GetMapping
	 * PUT -
	 * Delete
	 */
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	// private static List<BlogPost> posts = new ArrayList<>();

	//Give home page posts attribute
	@GetMapping("/")
	public String index(BlogPost blogpost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/index";
	}
	
	//give new page post attribute
	@GetMapping("/new")
	public String newPage(BlogPost blogpost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/new";
	}

	private BlogPost blogPost;
	
	//When the form submits it sends info to db
	@PostMapping(value = "/new")
	public String addNewBlogPost(BlogPost blogPost, Model model){
		blogPostRepository.save(blogPost);
		// posts.add(blogPost);
		model.addAttribute("id", blogPost.getId());
		model.addAttribute("postTitle", blogPost.getPostTitle());
		model.addAttribute("postAuthor", blogPost.getPostAuthor());
		model.addAttribute("postBody", blogPost.getPostBody());
		return "blogpost/result";
	}

	// Delete route for single post
	@DeleteMapping(value = "/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {

			// for(int i= 0; i < posts.size(); i++) {
			// 		if(id == posts.get(i).getId()) {
			// 			posts.remove(i);
			// 		}
			// }
			blogPostRepository.deleteById(id);
			
			return "blogpost/deleted";

	}

	// Route to form page for post show
	@GetMapping(value="/show/{id}")
	public String showPostPage(@PathVariable Long id, Model model) {
		BlogPost blogpost =  blogPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("posts", blogpost);
		
		return "blogpost/show";
	}
	
	// Route to form page for updating post
	@GetMapping(value="/update/{id}")
	public String updatePage(@PathVariable Long id, Model model) {
		BlogPost blogpost =  blogPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("posts", blogpost);
		
		return "blogpost/update";
	}
	
	// Put route for single post
	@PutMapping(value="/update/{id}")
	public String updatePostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
		
		BlogPost editedBlogpost =  blogPostRepository.findById(id).orElse(null);

		editedBlogpost.setPostTitle(blogPost.getPostTitle());
		editedBlogpost.setPostAuthor(blogPost.getPostAuthor());
		editedBlogpost.setPostBody(blogPost.getPostBody());

		blogPostRepository.save(editedBlogpost);
		
		model.addAttribute("id", editedBlogpost.getId());
		model.addAttribute("postTitle", editedBlogpost.getPostTitle());
		model.addAttribute("postAuthor", editedBlogpost.getPostAuthor());
		model.addAttribute("postBody", editedBlogpost.getPostBody());
		 
		return "blogpost/result";
		
	}
	
	@GetMapping("/crystalGame")
	public String getCrystalGame(BlogPost blogpost, Model model) {
		return "games/crystalGame";
	}

	@GetMapping("/rpsGame")
	public String getRPSGame(BlogPost blogpost, Model model) {
		return "games/rpsGame";
	}
	// @PutMapping("/update/{id}")
	// public String replaceBlogPost(@RequestBody BlogPost newPost, @PathVariable Long id) {
	//   return blogPostRepository.findById(id)
	// 	.map(blogPost -> {
	// 		blogPost.setPostTitle(newPost.getPostTitle());
	// 		blogPost.setPostAuthor(newPost.getPostAuthor());
	// 		blogPost.setPostBody(newPost.getPostBody());
	// 		blogPostRepository.save(newPost);
	// 		return "blogpost/index";
		   
	// 	})
	// 	.orElseGet(() -> {
	// 	  newPost.setId(id);
	// 	 blogPostRepository.save(newPost);
	// 	 return "blogpost/index";
		 
	// 	});
//	}



	
	
}


