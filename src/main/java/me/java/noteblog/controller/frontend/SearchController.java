package me.java.noteblog.controller.frontend;

import me.java.noteblog.constant.DictGroup;
import me.java.noteblog.controller.common.BaseController;
import me.java.noteblog.service.interfaces.content.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/s")
public class SearchController extends BaseController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/c")
    public String cateSearch(Model model, String q, Integer p) {
        int pageNo = StringUtils.isEmpty(p) ? 1 : p;
        model.addAttribute("searchKeywords", q);
        model.addAttribute("searchPage", searchService.searchWithDict(DictGroup.GROUP_CATE, q, pageNo));
        model.addAttribute("searchType", "c");
        return "frontend/search";
    }

    @GetMapping("/t")
    public String tagSearch(Model model, String q, Integer p) {
        int pageNo = StringUtils.isEmpty(p) ? 1 : p;
        model.addAttribute("searchKeywords", q);
        model.addAttribute("searchPage", searchService.searchWithDict(DictGroup.GROUP_TAG, q, pageNo));
        model.addAttribute("searchType", "t");
        return "frontend/search";
    }

    @GetMapping("/w")
    public String wordSearch(Model model, String q, Integer p) {
        int pageNo = StringUtils.isEmpty(p) ? 1 : p;
        model.addAttribute("searchKeywords", q);
        model.addAttribute("searchPage", searchService.searchWithWords(q, pageNo));
        model.addAttribute("searchType", "w");
        return "frontend/search";
    }
}
