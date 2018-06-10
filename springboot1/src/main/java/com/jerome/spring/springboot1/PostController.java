package com.jerome.spring.springboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@EnableAutoConfiguration
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(value="/posts/get/{id}", method= RequestMethod.GET)
//    @ResponseBody\
    public Post getSinglePost( @PathVariable("id") int id ) {
        System.out.println( "__KENNY__ getSinglePost() START!!" );
        System.out.println( "__KENNY__ id : " + id );

        return postRepository.findById( id );
    }

    @RequestMapping(value="/posts/insert", method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_UTF8_VALUE )
//    @ResponseBody
    public Post insertPost( @RequestBody Post post ) {
        System.out.println( "__KENNY__ insertPost() START!!" );
        System.out.println( "__KENNY__ id : " + post.getId() );

        postRepository.save( post );
        return postRepository.findById( post.getId() );
    }

    @RequestMapping( value="/posts/error", method=RequestMethod.POST )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public Post notFoundErrorPost( @RequestBody Post post ) {
        return post;
    }

    @RequestMapping( value="/posts/error/entity", method=RequestMethod.POST )
    public ResponseEntity<Post> notFoundErrorEntityPost(@RequestBody Post post ) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<Post>( post, httpHeaders, HttpStatus.NOT_FOUND );
    }

    @RequestMapping(value="/posts/new", method=RequestMethod.GET)
    public String newPost( Model model ) {
        model.addAttribute( "post", new Post() );
        return "new";
    }

    @RequestMapping(value="/posts", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post, Model model ) {
        model.addAttribute( "post", post );

        //post.setId(post.getId());
        postRepository.save(post);
        //Post findPost = postRepository.findById( "123" );
        //System.out.println( "__jerome__ findPost.id : " + findPost.getId() );

        return "show";
    }
}