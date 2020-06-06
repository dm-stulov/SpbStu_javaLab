package spbstu.ponomarev.step.MVC.controller;

import spbstu.ponomarev.step.MVC.model.Model;

public class BaseController {
  protected Model model;

  public BaseController(Model model) throws Exception {
    this.model = model;
  }
}
