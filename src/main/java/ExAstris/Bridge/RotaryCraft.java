package ExAstris.Bridge;

import ExAstris.Block.BlockQStronglyCompressedStone;
import ExAstris.Block.BlockStronglyCompressedStone;
import net.minecraft.block.Block;

public class RotaryCraft {
	
	public static Block stronglyCompressedStone()
	{
		return new BlockStronglyCompressedStone();
	}
	
	public static Block qStronglyCompressedStone()
	{
		return new BlockQStronglyCompressedStone();
	}

}
