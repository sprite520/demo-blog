package rhr.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {


    @GetMapping("/album")
    public String album(){
        return "photo_album";
    }

    @GetMapping("/album/pic")
    public String picture(){
        return "picture";
    }
}
