
package datec.com.bo.models.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import datec.com.bo.models.entity.Recibo;

@Service
public interface IReciboServ { public Optional<Recibo> buscarId(Long idrecibo); }
