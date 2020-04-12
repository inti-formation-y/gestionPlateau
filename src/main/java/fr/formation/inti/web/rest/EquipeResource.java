package fr.formation.inti.web.rest;

import fr.formation.inti.domain.Equipe;
import fr.formation.inti.repository.EquipeRepository;
import fr.formation.inti.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link fr.formation.inti.domain.Equipe}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class EquipeResource {

    private final Logger log = LoggerFactory.getLogger(EquipeResource.class);

    private static final String ENTITY_NAME = "equipe";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EquipeRepository equipeRepository;

    public EquipeResource(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    /**
     * {@code POST  /equipes} : Create a new equipe.
     *
     * @param equipe the equipe to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new equipe, or with status {@code 400 (Bad Request)} if the equipe has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/equipes")
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) throws URISyntaxException {
        log.debug("REST request to save Equipe : {}", equipe);
        if (equipe.getId() != null) {
            throw new BadRequestAlertException("A new equipe cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Equipe result = equipeRepository.save(equipe);
        return ResponseEntity.created(new URI("/api/equipes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /equipes} : Updates an existing equipe.
     *
     * @param equipe the equipe to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated equipe,
     * or with status {@code 400 (Bad Request)} if the equipe is not valid,
     * or with status {@code 500 (Internal Server Error)} if the equipe couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/equipes")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe) throws URISyntaxException {
        log.debug("REST request to update Equipe : {}", equipe);
        if (equipe.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Equipe result = equipeRepository.save(equipe);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, equipe.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /equipes} : get all the equipes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of equipes in body.
     */
    @GetMapping("/equipes")
    public List<Equipe> getAllEquipes() {
        log.debug("REST request to get all Equipes");
        return equipeRepository.findAll();
    }

    /**
     * {@code GET  /equipes/:id} : get the "id" equipe.
     *
     * @param id the id of the equipe to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the equipe, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/equipes/{id}")
    public ResponseEntity<Equipe> getEquipe(@PathVariable Long id) {
        log.debug("REST request to get Equipe : {}", id);
        Optional<Equipe> equipe = equipeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(equipe);
    }

    /**
     * {@code DELETE  /equipes/:id} : delete the "id" equipe.
     *
     * @param id the id of the equipe to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/equipes/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        log.debug("REST request to delete Equipe : {}", id);
        equipeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
