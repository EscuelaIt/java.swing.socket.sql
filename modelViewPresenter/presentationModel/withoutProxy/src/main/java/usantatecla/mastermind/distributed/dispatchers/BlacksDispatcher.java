package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class BlacksDispatcher extends Dispatcher {

	public BlacksDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayController)this.acceptorController).getBlacks(position));
	}

}
