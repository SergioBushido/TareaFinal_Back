package com.gestor.gestortareasbackend.controllers;


import com.gestor.gestortareasbackend.model.Tag;
import com.gestor.gestortareasbackend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{tagId}")
    public Tag getTagById(@PathVariable Long tagId) {
        return tagService.getTagById(tagId);
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @PutMapping("/{tagId}")
    public Tag updateTag(@PathVariable Long tagId, @RequestBody Tag tagDetails) {
        return tagService.updateTag(tagId, tagDetails);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}