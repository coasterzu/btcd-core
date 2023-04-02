package com.neemre.btcdcli4j.core.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.neemre.btcdcli4j.core.common.Defaults;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction extends Entity {

	@Setter(AccessLevel.NONE)
	private BigDecimal amount;
	@Setter(AccessLevel.NONE)
	private BigDecimal fee;
	private Integer confirmations;
	private Boolean generated;
	@JsonProperty("blockhash")
	private String blockHash;
	@JsonProperty("blockindex")
	private Integer blockIndex;
	@JsonProperty("blocktime")
	private Long blockTime;
	@JsonProperty("txid")
	private String txId;
	@JsonProperty("walletconflicts")
	private List<String> walletConflicts;
	private Long time;
	@JsonProperty("timereceived")
	private Long timeReceived;
	private String comment;
	private String to;
	private List<PaymentOverview> details;
	private String hex;


	public Transaction(BigDecimal amount, BigDecimal fee, Integer confirmations, Boolean generated, 
			String blockHash, Integer blockIndex, Long blockTime, String txId, 
			List<String> walletConflicts, Long time, Long timeReceived, String comment, String to, 
			List<PaymentOverview> details, String hex) {
		setAmount(amount);
		setFee(fee);
		setConfirmations(confirmations);
		setGenerated(generated);
		setBlockHash(blockHash);
		setBlockIndex(blockIndex);
		setBlockTime(blockTime);
		setTxId(txId);
		setWalletConflicts(walletConflicts);
		setTime(time);
		setTimeReceived(timeReceived);
		setComment(comment);
		setTo(to);
		setDetails(details);
		setHex(hex);
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount.setScale(Defaults.DECIMAL_SCALE, Defaults.ROUNDING_MODE);
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee.setScale(Defaults.DECIMAL_SCALE, Defaults.ROUNDING_MODE);
	}
}