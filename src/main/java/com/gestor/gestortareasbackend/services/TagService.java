package com.gestor.gestortareasbackend.services;

import com.gestor.gestortareasbackend.model.Tag;
import com.gestor.gestortareasbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId).orElse(null);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long tagId, Tag tagDetails) {
        Tag tag = tagRepository.findById(tagId).orElse(null);
        if (tag != null) {
            // Actualizar los detalles de la etiqueta
            // tagDetails.setId(tagId); // Si se desea mantener el mismo ID
            return tagRepository.save(tagDetails);
        }
        return null;
    }

    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}