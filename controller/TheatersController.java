package controller;

import service.TheatersService;

public class TheatersController {
    private static TheatersController controller;
    public static TheatersController theatersController() {
        if(controller == null) controller = new TheatersController();
        return controller;
    }

    public void showTheaters(){
        TheatersService.getService().searchTheaters();
    }

}

