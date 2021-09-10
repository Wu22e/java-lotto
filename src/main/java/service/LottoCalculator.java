package service;

import domain.Account;
import domain.Lotto;
import domain.Number;
import domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

	private static final Integer INIT_NUMBER = 0;

	private List<Rank> container;

	public LottoCalculator() {
		container = new ArrayList<>();
	}

	public List<Rank> getResult(List<Lotto> lottoList, Lotto lottoWinningNumber, Number bonusNumber) {
		validateLottoList(lottoList, lottoWinningNumber, bonusNumber);
		return container;
	}

	public Integer getAutoLottoCount(Account account, List<Lotto> manualLottos) {
		return account.lottoCountByUnit(manualLottos.size());
	}

	public Integer getManualLottoCount(List<Lotto> manualLottos) {
		return manualLottos.size();
	}

	private void validateLottoList(List<Lotto> lottoList, Lotto lottoWinningNumber, Number bonusNumber) {
		for (int number = INIT_NUMBER ; number < lottoList.size() ; ++number) {
			Integer countOfMatches = numberOfMatches(lottoList.get(number), lottoWinningNumber);
			Boolean bonusStatus = bonusNumberOfMatches(lottoList.get(number), bonusNumber);
			Rank rank = Rank.rank(countOfMatches, bonusStatus);
			container.add(rank);
		}
	}

	private Integer numberOfMatches(Lotto lotto, Lotto lottoWinningNumber) {
		return lotto.numberOfMatches(lottoWinningNumber);
	}

	private Boolean bonusNumberOfMatches(Lotto lotto, Number bonusNumber) {
		return lotto.bonusNumberOfMatches(bonusNumber);
	}
}
