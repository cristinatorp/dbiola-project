package IKT446.dbiola.api;

import IKT446.dbiola.exception.ActorNotFoundException;
import IKT446.dbiola.model.Actor;
import IKT446.dbiola.repository.ActorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorRepo actorRepo;

    @Autowired
    public ActorController(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    @GetMapping
    public List<Actor> getActors() {
        return actorRepo.findAll();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorRepo.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

}
