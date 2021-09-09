package tv;

public class TV {
	private int channel;		// 1~255 채널
	private int volume;			// 0~100 볼륨
	private boolean power;		
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void volume(int volume) {
		if ( volume < 0 || volume > 100) {
			return;
		} else {
			this.volume = volume;
		}
	}
	
	public void volume (boolean up) {
		if (up) {
			this.volume++;
			if(this.volume > 100 ) {
				this.volume = 1;
			}
		} else {
			this.volume--;
			if(this.volume < 0 ) {
				this.volume = 0;
			}
		}
	}
	
	public void channel (boolean up) {
		// chaneel(channel + ( up ? 1 : -1 ));
		if (up) {
			channel(channel+1);
		} else {
			channel(channel-1);
		}
	}
	
	public void channel (int channel) {
		this.channel = channel;
	}

	public void status() {
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + power + "]"); 
	}
}
