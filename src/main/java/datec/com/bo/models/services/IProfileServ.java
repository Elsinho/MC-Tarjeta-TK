
package datec.com.bo.models.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import datec.com.bo.models.entity.AtcProfileEmpresa;

@Service
public interface IProfileServ { public Optional<AtcProfileEmpresa> buscarIdcyber(Long idcyber); }
