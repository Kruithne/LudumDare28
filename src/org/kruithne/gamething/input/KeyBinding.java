package org.kruithne.gamething.input;

import java.util.Arrays;
import java.util.List;

public enum KeyBinding
{
	UNBOUND,
	FORWARD(17, 200),
	BACKWARD(31, 208),
	RIGHT(32, 205),
	LEFT(30, 203),
	RELOAD(19);

	private KeyBinding(Integer... keys)
	{
		this.keys = Arrays.asList(keys);
	}

	public static KeyBinding getBinding(int key)
	{
		for (KeyBinding binding : values())
			if (binding.keys.contains(key))
				return binding;

		return KeyBinding.UNBOUND;
	}

	private List<Integer> keys;
}
