package step2.ui;

import step2.*;

public class App {


    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        Money purchasingMoney = inputHandler.getPurchasingMoney();
        Amount manualPurchasingAmount = inputHandler.getManualAmount();
        LottoPurchaseRequest purchaseRequest = inputHandler.getPurchaseRequest(purchasingMoney, manualPurchasingAmount);
        Lottos lottos = LottoMarketDealer.purchase(purchaseRequest);
        int autoAmount = lottos.getCount() - manualPurchasingAmount.getValue();
        OutputHandler.print("수동으로 " + manualPurchasingAmount.getValue() + "개, 자동으로 " + autoAmount + "개를 구매했습니다");
        OutputHandler.print(lottos.toString());

        InputNumbers winNumbers = inputHandler.getPreviousWeekWinNumbers();
        LottoNumber bonusNumber = inputHandler.getBonusNumber();
        OutputHandler.print(System.lineSeparator());
        OutputHandler.print("당첨 통계");
        OutputHandler.print("---------");

        WinResults winResults = lottos.getWinResults(winNumbers.getNumbers(), bonusNumber);
        OutputHandler.print(winResults.getResult());
        Money winningMoney = winResults.getWinningMoneySum();
        OutputHandler.print("총 수익률은 " + RateCalculator.calculate(winningMoney, purchasingMoney) + "입니다");
    }
}