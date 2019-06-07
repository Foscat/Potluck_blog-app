package com.tts.PotluckAdventures.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.PotluckAdventures.BlogPost.BlogPost;
import com.tts.PotluckAdventures.BlogPost.BlogPostRepository;

@Service
public abstract class BlogService implements InterfaceBlogService {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
//	@Override
	public void updatePost(BlogPost blogPost) {
		blogPostRepository.save(blogPost);
	}
}
