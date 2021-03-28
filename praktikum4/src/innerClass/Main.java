package innerClass;

public class Main {
	public static void main(String[] args) {
		
		CPU cpu = new CPU();
		
		CPU.Processor prosesor = cpu.new Processor();
		//CPU.RAM ram = cpu.new RAM();
		System.out.println("Processor cache = "+ prosesor.getCache());
		System.out.println("RAM Clock speed = "+ prosesor.getCache());
	}
	
}