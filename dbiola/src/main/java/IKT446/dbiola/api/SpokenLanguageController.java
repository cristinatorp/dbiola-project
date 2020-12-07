package IKT446.dbiola.api;

import IKT446.dbiola.repository.SpokenLanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
public class SpokenLanguageController {

    private final SpokenLanguageRepo languageRepo;

    @Autowired
    public SpokenLanguageController(SpokenLanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

}
