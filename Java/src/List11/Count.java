package List11;

class Count extends Thread {
	private static IntCell n = new IntCell();

	@Override
	public void run() {
		int temp;
		for (int i = 0; i < 200000; i++) {
			temp = n.getN();
			//tu dwa watki moga pobrac n
			n.setN(temp + 1);
		}
	}


	public static void main(String[] args) throws InterruptedException {
		Count p = new Count();
		Count q = new Count();
		p.start();
		q.start();
		try {
			p.join();
			q.join();
		} catch (InterruptedException e) {
		}
		System.out.println("The value of n is " + n.getN());
	}
}
