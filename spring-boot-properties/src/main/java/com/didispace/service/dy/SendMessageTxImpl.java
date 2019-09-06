package com.didispace.service.dy;

import com.didispace.service.SendMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SendMessageTxImpl implements A {

	@Override
	public SendMessageType getType() {
		return SendMessageType.Tx;
	}
}
