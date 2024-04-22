package com.example.demo.service;

import com.example.demo.dto.ApiResponseList;
import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.ProductoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final EntityManager entityManager;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, EntityManager entityManager) {
        this.productoRepository = productoRepository;
        this.entityManager = entityManager;
    }

    public ApiResponseList<?> insertAndListProducts(int idProducto, String nombre, LocalDate fechaRegistro) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insert_and_list_products");
        query.registerStoredProcedureParameter("id_producto", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fec_registro", LocalDate.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("list_producto", void.class, ParameterMode.REF_CURSOR);
        query.registerStoredProcedureParameter("codigo_respuesta", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("mensaje_respuesta", String.class, ParameterMode.OUT);

        query.setParameter("id_producto", idProducto);
        query.setParameter("nombre", nombre);
        query.setParameter("fec_registro", fechaRegistro);

        query.execute();

        Integer codigoRespuesta = (Integer) query.getOutputParameterValue("codigo_respuesta");
        String mensajeRespuesta = (String) query.getOutputParameterValue("mensaje_respuesta");
        
        if (codigoRespuesta == 1) {
            return new ApiResponseList<>(codigoRespuesta, mensajeRespuesta, new ArrayList<>());
        }
        
        return new ApiResponseList<>(codigoRespuesta, mensajeRespuesta, (List<?>) query.getResultList());
        
       
    }
}
