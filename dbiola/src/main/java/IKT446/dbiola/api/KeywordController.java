package IKT446.dbiola.api;

import IKT446.dbiola.model.Keyword;
import IKT446.dbiola.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordRepo keywordRepo;

    @Autowired
    public KeywordController(KeywordRepo keywordRepo) {
        this.keywordRepo = keywordRepo;
    }

    @GetMapping
    public List<Keyword> getKeywords() {
        return keywordRepo.findAll();
    }

}
