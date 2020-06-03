package lotto.service;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.collections.RewardType;
import lotto.collections.WinningNumbers;
import lotto.collections.WinningTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public class WinningService {

	public static WinningNumbers createWinningNumbers(final String winningNumber) {
		List<Integer> winningNumberBeforeList = Arrays.stream(winningNumber.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.collect(Collectors.toList());
		return new WinningNumbers(winningNumberBeforeList);
	}

	public static Money calculateProfit(List<RewardType> lottoStatistics) {
		int value = Arrays.stream(RewardType.values())
			.filter(lottoStatistics::contains)
			.map(type -> type.getReward().getValue() * lottoStatistics.stream()
				.filter(element -> element.equals(type))
				.mapToInt(i -> 1)
				.sum())
			.reduce(0, Integer::sum);
		return new Money(value);
	}

	public LottoResult getLottoResult(final LottoTickets lottoTickets, final WinningTicket winningTicket) {
		return lottoTickets.getLottoTickets().stream()
			.map(winningTicket::checkLottoNumbers)
			.collect(collectingAndThen(toList(), LottoResult::new));
	}

	public int getMatchCount(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
		return winningNumbers.getWinningNumbers().stream()
			.mapToInt(lottoTicket::getMatchCount).sum();
	}

	public static boolean isBonusBall(final LottoTickets lottoTickets, final LottoNumber bonusBall) {
		return lottoTickets.getLottoTickets().stream()
			.anyMatch(ticket -> ticket.doesContainBonusBall(bonusBall));
	}
}
