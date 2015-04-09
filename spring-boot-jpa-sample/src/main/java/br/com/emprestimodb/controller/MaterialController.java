
package br.com.emprestimodb.controller;

import br.com.emprestimodb.entity.Material;
import br.com.emprestimodb.service.MaterialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {
    
    @Autowired 
    MaterialService materialService;
    
    @RequestMapping(value="/materiais",method=RequestMethod.GET)
    public List<Material> getAll(){
        return materialService.findAll();
    }
    
    @RequestMapping(value="/materiais/{id}",method=RequestMethod.GET)
    public Material getOne(@PathVariable Long id){
        return materialService.findById(id).get();
    } 
    
    @RequestMapping(value="/materiais/{id}",method=RequestMethod.DELETE)
    public void remove(@PathVariable Long id){
        materialService.delete(id);
    }      
    
    @RequestMapping(value = "/materiais/novo", method = RequestMethod.POST)
    public void add(Material material){
        System.out.println(material.toString());
        materialService.save(material);
    }
    
}