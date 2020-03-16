package black.mesa.springmvcdemo.controller;

import black.mesa.springmvcdemo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends AbstractController {
    private String viewName;

    @Autowired
    private IHelloService helloService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {


        ModelAndView mv = new ModelAndView(getViewName());
        mv.addObject("message", helloService.sayHello());
        return mv;
    }


    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName;
    }

}
