package com.accounting.project.accounting.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class JournalEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String transaction_no;
	private String transaction_no_format;
	private String memo;
	private String transaction_date;
	private int transaction_status_id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "journal_id", referencedColumnName = "id")
	private List<TransactionAccountLine> transaction_account_lines;
	private double total_debit;
	private double total_credit;
	private String total_debit_currency_format;
	private String total_credit_currency_format;
	@ElementCollection
	private List<String> attachments;
	private boolean locked;
	private boolean reconciled;
	private Date created_at;
	private Date updated_at;
	private String currency_code;
	private double currency_rate;

	

	public JournalEntry(String transaction_no, String transaction_no_format, String memo, String transaction_date,
			int transaction_status_id, List<TransactionAccountLine> transaction_account_lines, double total_debit,
			double total_credit, String total_debit_currency_format, String total_credit_currency_format,
			List<String> attachments, boolean locked, boolean reconciled, Date created_at, Date updated_at,
			String currency_code, double currency_rate) {
		super();
		this.transaction_no = transaction_no;
		this.transaction_no_format = transaction_no_format;
		this.memo = memo;
		this.transaction_date = transaction_date;
		this.transaction_status_id = transaction_status_id;
		this.transaction_account_lines = transaction_account_lines;
		this.total_debit = total_debit;
		this.total_credit = total_credit;
		this.total_debit_currency_format = total_debit_currency_format;
		this.total_credit_currency_format = total_credit_currency_format;
		this.attachments = attachments;
		this.locked = locked;
		this.reconciled = reconciled;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.currency_code = currency_code;
		this.currency_rate = currency_rate;
	}
	

	public int getTransaction_status_id() {
		return transaction_status_id;
	}

	public void setTransaction_status_id(int transaction_status_id) {
		this.transaction_status_id = transaction_status_id;
	}

	public JournalEntry() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(String transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}


	public List<TransactionAccountLine> getTransaction_account_lines() {
		return transaction_account_lines;
	}

	public void setTransaction_account_lines(List<TransactionAccountLine> transaction_account_lines) {
		this.transaction_account_lines = transaction_account_lines;
	}

	public double getTotal_debit() {
		return total_debit;
	}

	public void setTotal_debit(double total_debit) {
		this.total_debit = total_debit;
	}

	public double getTotal_credit() {
		return total_credit;
	}

	public void setTotal_credit(double total_credit) {
		this.total_credit = total_credit;
	}

	public String getTotal_debit_currency_format() {
		return total_debit_currency_format;
	}

	public void setTotal_debit_currency_format(String total_debit_currency_format) {
		this.total_debit_currency_format = total_debit_currency_format;
	}

	public String getTotal_credit_currency_format() {
		return total_credit_currency_format;
	}

	public void setTotal_credit_currency_format(String total_credit_currency_format) {
		this.total_credit_currency_format = total_credit_currency_format;
	}

	public List<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isReconciled() {
		return reconciled;
	}

	public void setReconciled(boolean reconciled) {
		this.reconciled = reconciled;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public double getCurrency_rate() {
		return currency_rate;
	}

	public void setCurrency_rate(double currency_rate) {
		this.currency_rate = currency_rate;
	}

	public String getTransaction_no_format() {
		return transaction_no_format;
	}

	public void setTransaction_no_format(String transaction_no_format) {
		this.transaction_no_format = transaction_no_format;
	}

}