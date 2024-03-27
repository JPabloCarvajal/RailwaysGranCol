package jp.sgttp.controller;
import jp.sgttp.model.SGTTPModel;
import jp.sgttp.view.SGTTPView;

public class SGTTPController {

    private SGTTPModel model;
    private SGTTPView view;
  
    public SGTTPController(SGTTPModel model, SGTTPView view) {
      this.model = model;
      this.view = view;
    }
  
    public void start() {
      view.init(new String[]{model.getTitle()});
    }
    
  }
