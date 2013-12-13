package com.github.cjm0000000.mmt.core.test.parser.message.weixin;

import static org.junit.Assert.assertEquals;

import com.github.cjm0000000.mmt.core.message.Message;
import com.github.cjm0000000.mmt.core.message.recv.weixin.MediaMessage;
import com.github.cjm0000000.mmt.core.test.parser.message.AbstractMsgParser;

/**
 * Media message test template
 * @author lemon
 * @version 2.0
 *
 */
public abstract class MediaMessageParser extends AbstractMsgParser {
	
	/**
	 * make specific nodes without media id
	 * @param sb
	 * @param original
	 */
	protected abstract void makeSpecNodesWithoutMediaId(StringBuilder sb, Message original);
	
	/**
	 * verify specific fields without media id
	 * @param after
	 * @param before
	 */
	protected abstract void verifySpecFieldsWithoutMediaId(Message after, Message before);
	
	/**
	 * get message instance without set value for media id
	 * @return
	 */
	protected abstract MediaMessage getMsgInstanceWithoutMediaId();

	@Override
	protected final void makeSpecNodesWithouMsgId(StringBuilder sb, Message original) {
		MediaMessage msg = (MediaMessage) original;
		sb.append("<MediaId><![CDATA[" + msg.getMediaId() + "]]></MediaId>");
		makeSpecNodesWithoutMediaId(sb, original);
	}

	@Override
	protected final void verifySpecFieldsWithoutMsgId(Message after, Message before) {
		MediaMessage m_before = (MediaMessage) before;
		MediaMessage m_after = (MediaMessage) after;
		assertEquals(m_after.getMediaId(), m_before.getMediaId());
		verifySpecFieldsWithoutMediaId(m_after, m_before);
	}

	@Override
	protected final Message getMsgInstanceWithoutMsgId() {
		MediaMessage msg = getMsgInstanceWithoutMediaId();
		msg.setMediaId("Okq_aCQbG0iFQ6b89SAB2pP3-1jqAHehh2QSiPihKB6-Uwp6VlB24KbKsmX1sqVl");
		return msg;
	}

}
