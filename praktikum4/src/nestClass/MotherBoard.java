package nestClass;

class MotherBoard {
	// static nested class
	static class USB{
		int usb2 = 1;
		int usb3 = 2;
		
		int getTotalPorts(){
			return usb2 + usb3;
		}
	}
}