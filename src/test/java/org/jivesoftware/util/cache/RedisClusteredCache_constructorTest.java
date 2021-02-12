package org.jivesoftware.util.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.directtruststandards.timplus.cluster.cache.SpringBaseTest;
import org.jivesoftware.openfire.cluster.NodeID;
import org.junit.jupiter.api.Test;

public class RedisClusteredCache_constructorTest extends SpringBaseTest
{
	@Test
	public void testConstructRedisClusteredCache_assertSuccessfullyCreated() throws Exception
	{
		final RedisClusteredCache cache = new RedisClusteredCache("JUnitCache", 50, 50000, NodeID.getInstance(new byte[] {0,0,0,0}));
		
		assertNotNull(cache);
		assertNotNull(cache.remotelyCached);
		assertNotNull(cache.locallyCached);
		assertEquals("JUnitCache", cache.getName());
		assertEquals(NodeID.getInstance(new byte[] {0,0,0,0}), cache.nodeId);
		assertEquals(50, cache.getMaxCacheSize());
		assertEquals(50000, cache.getMaxLifetime());
	}
}
