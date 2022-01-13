package Core._Banko;

public class aTransaction {

	
	
	public void post(_Account a, float ammount)
	{
		
	}
	
	public enum Direction {
		Credit, Debit;
	}

	public enum Type {
		Deposit(Direction.Credit), Withdrawal(Direction.Debit), Expenditure(Direction.Debit);

		private Direction dir;

		private Type(Direction dir) {
			this.dir = dir;
		}

		public int signum() {
			if (this.dir == Direction.Credit)
				return 1;
			if (this.dir == Direction.Debit)
				return -1;

			return 0;
		}
	}

}
