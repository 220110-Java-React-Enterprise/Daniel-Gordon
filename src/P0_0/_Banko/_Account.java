package Core._Banko;

public class _Account {

	protected final Type AccountType;
	protected final int AccountNumber;
	protected final int RouttingNumber;

	public float fundage = 0;

	public _Account(Type type) {
		this.AccountType = type;
		this.AccountNumber = this.genAcctNum();
		this.RouttingNumber = this.genRtnNum();
	}

	private int genAcctNum() {
		return 0;
	}

	private int genRtnNum() {
		return 0;
	}

	public String toString() {
		return this.AccountType.pfx + this.AccountNumber + "::" + this.RouttingNumber;
	}

	public enum Type {
		Checking("CH"), Savings("SA"), Credit("CR");

		private String pfx;

		private Type(String pfx) {
			this.pfx = pfx;
		}

		public String getPrefix() {
			return this.pfx;
		}
	}
}
