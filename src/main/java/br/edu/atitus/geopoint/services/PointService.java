package br.edu.atitus.geopoint.services;

import br.edu.atitus.geopoint.dtos.PointRequest;
import br.edu.atitus.geopoint.entities.PointEntity;
import br.edu.atitus.geopoint.repositories.PointRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class PointService {

    private final PointRepository repository;

    public PointService(PointRepository repository) {
        this.repository = repository;
    }

    private void validate(PointRequest request) {

        if (request.name() == null || request.name().isBlank()) {
            throw new RuntimeException("Nome inválido");
        }

        if (request.name().length() > 100) {
            throw new RuntimeException("Nome muito longo");
        }

        if (request.description() != null &&
                request.description().length() > 255) {
            throw new RuntimeException("Descrição muito longa");
        }

        if (request.latitude() == null ||
                request.latitude().compareTo(BigDecimal.valueOf(-90)) < 0 ||
                request.latitude().compareTo(BigDecimal.valueOf(90)) > 0) {
            throw new RuntimeException("Latitude inválida");
        }

        if (request.longitude() == null ||
                request.longitude().compareTo(BigDecimal.valueOf(-180)) < 0 ||
                request.longitude().compareTo(BigDecimal.valueOf(180)) > 0) {
            throw new RuntimeException("Longitude inválida");
        }
    }

    public PointEntity insert(PointRequest request) {

        validate(request);

        PointEntity point = new PointEntity();

        point.setId(UUID.randomUUID());
        point.setName(request.name());
        point.setDescription(request.description());
        point.setLatitude(request.latitude());
        point.setLongitude(request.longitude());

        return repository.insert(point);
    }

    public List<PointEntity> findAll() {
        return repository.findAll();
    }

    public PointEntity findById(UUID id) {

        PointEntity point = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Ponto não localizado com o ID: " + id));

        return point;
    }

    public PointEntity update(UUID id, PointRequest request) {

        validate(request);

        PointEntity point = findById(id);

        point.setName(request.name());
        point.setDescription(request.description());
        point.setLatitude(request.latitude());
        point.setLongitude(request.longitude());

        if (repository.update(point) == 0) {
            throw new NoSuchElementException(
                    "Ponto não localizado com o ID: " + id);
        }

        return point;
    }

    public void delete(UUID id) {

        if (repository.delete(id) == 0) {
            throw new NoSuchElementException(
                    "Ponto não localizado com o ID: " + id);
        }
    }
}