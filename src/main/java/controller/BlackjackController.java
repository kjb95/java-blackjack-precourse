package controller;

import java.util.List;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class BlackjackController {
    public void run() {
        requestPlayerNames();
    }

    private void requestPlayerNames() {

        List<String> playerNames = Utils.exceptionHandlingRepeat(InputView::requestPlayerNames, OutputView::printErrorMessage);
    }

}
