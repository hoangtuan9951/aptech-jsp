/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import dto.SinhVienDTO;
import model.SinhVien;

/**
 *
 * @author ADMIN
 */
public class SinhvienDAO {
    private EntityManager em = Persistence.createEntityManagerFactory("DemoWeb1PU").createEntityManager();
    
    public List<SinhVienDTO> finAllSinhviens(){
      return em.createQuery("select a from SinhVien a", SinhVien.class)
                .getResultList()
                .stream()
//                .map(it -> {
//                    return toDTO(it);
//                })
//                .map(it -> toDTO(it))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    
    private SinhVienDTO toDTO(SinhVien it) {
        SinhVienDTO dto = new SinhVienDTO();
        dto.setId(it.getId());
        dto.setName(it.getName());
        dto.setLopHoc(it.getLophocId().getName());
        
        return dto;
    }

}
