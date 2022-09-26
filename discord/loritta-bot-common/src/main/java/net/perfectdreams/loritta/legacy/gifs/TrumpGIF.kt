package net.perfectdreams.loritta.legacy.gifs

import net.perfectdreams.loritta.legacy.Loritta
import net.perfectdreams.loritta.legacy.utils.ImageUtils
import net.perfectdreams.loritta.legacy.utils.LorittaImage
import net.perfectdreams.loritta.legacy.utils.extensions.readImage
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.stream.FileImageOutputStream

object TrumpGIF {
	suspend fun getGIF(toUse: BufferedImage, toUse2: BufferedImage): File {
		var ogTeste = ImageUtils.toBufferedImage(toUse.getScaledInstance(240, 240, BufferedImage.SCALE_SMOOTH))
		var ogTeste2 = ImageUtils.toBufferedImage(toUse2.getScaledInstance(240, 240, BufferedImage.SCALE_SMOOTH))

		var fileName = Loritta.TEMP + "trump-" + System.currentTimeMillis() + ".gif"
		var output = FileImageOutputStream(File(fileName))
		val writer = GifSequenceWriter(output, BufferedImage.TYPE_INT_ARGB, 10, true)

		for (i in 0..70) {
			var ogImage = readImage(File(Loritta.ASSETS + "trump/frame_${i}_delay-0.1s.gif"))
			var image = BufferedImage(ogImage.width, ogImage.height, BufferedImage.TYPE_INT_ARGB)
			image.graphics.drawImage(ogImage, 0, 0, null)
			if (frames.size > i) {
				var skew = frames[i]

				var teste = BufferedImage(ogTeste.width, ogImage.height, BufferedImage.TYPE_INT_ARGB)
				teste.graphics.drawImage(ogTeste, 0, 0, null)

				var ogGraph = image.graphics

				var javaxt = LorittaImage(teste)

				javaxt.setCorners(skew.x0, skew.y0, // UL
						skew.x1, skew.y1, // UR
						skew.x2, skew.y2, // LR
						skew.x3, skew.y3) // LL

				ogGraph.drawImage(javaxt.bufferedImage, 0, 0, null)
			}

			if (frames2.size > i) {
				var skew = frames2[i]

				var teste = BufferedImage(ogTeste2.width, ogImage.height, BufferedImage.TYPE_INT_ARGB)
				teste.graphics.drawImage(ogTeste2, 0, 0, null)

				var ogGraph = image.graphics

				var javaxt = LorittaImage(teste)

				javaxt.setCorners(skew.x0, skew.y0, // UL
						skew.x1, skew.y1, // UR
						skew.x2, skew.y2, // LR
						skew.x3, skew.y3) // LL

				ogGraph.drawImage(javaxt.bufferedImage, 0, 0, null)
			}
			writer.writeToSequence(image)
		}
		writer.close()
		output.close()
		return File(fileName)
	}

	val frames = listOf(
			SkewCorners(160F, 95F, // UL
					218F, 110F, // UR
					196F, 189F, // LR
					138F, 170F), // LL
			SkewCorners(168F, 94F, // UL
					228F, 103F, // UR
					215F, 182F, // LR
					154F, 169F), // LL
			SkewCorners(174F, 96F, // UL
					234F, 100F, // UR
					228F, 178F, // LR
					167F, 172F), // LL
			SkewCorners(177F, 98F, // UL
					235F, 99F, // UR
					236F, 176F, // LR
					176F, 175F), // LL
			SkewCorners(180F, 98F, // UL
					234F, 97F, // UR
					237F, 173F, // LR
					182F, 176F), // LL
			SkewCorners(176F, 99F, // UL
					231F, 95F, // UR
					236F, 170F, // LR
					181F, 176F), // LL
			SkewCorners(172F, 97F, // UL
					229F, 93F, // UR
					234F, 169F, // LR
					177F, 174F), // LL
			SkewCorners(172F, 96F, // UL
					230F, 93F, // UR
					234F, 170F, // LR
					176F, 173F), // LL
			SkewCorners(172F, 96F, // UL
					231F, 94F, // UR
					234F, 171F, // LR
					175F, 173F), // LL
			SkewCorners(170F, 96F, // UL
					229F, 94F, // UR
					232F, 171F, // LR
					173F, 173F), // LL
			SkewCorners(169F, 96F, // UL
					228F, 94F, // UR
					231F, 171F, // LR
					172F, 173F), // LL
			SkewCorners(170F, 96F, // UL
					228F, 93F, // UR
					231F, 170F, // LR
					172F, 173F), // LL
			SkewCorners(169F, 94F, // UL
					228F, 92F, // UR
					231F, 169F, // LR
					172F, 172F), // LL
			SkewCorners(169F, 94F, // UL
					227F, 91F, // UR
					230F, 168F, // LR
					172F, 171F), // LL
			SkewCorners(168F, 93F, // UL
					226F, 91F, // UR
					229F, 168F, // LR
					171F, 170F), // LL
			SkewCorners(167F, 94F, // UL
					225F, 92F, // UR
					228F, 168F, // LR
					170F, 171F), // LL
			SkewCorners(167F, 94F, // UL
					225F, 92F, // UR
					228F, 168F, // LR
					170F, 171F), // LL
			SkewCorners(168F, 93F, // UL
					226F, 91F, // UR
					229F, 168F, // LR
					170F, 170F), // LL
			SkewCorners(167F, 92F, // UL
					225F, 90F, // UR
					229F, 167F, // LR
					170F, 169F), // LL
			SkewCorners(166F, 90F, // UL
					225F, 88F, // UR
					228F, 165F, // LR
					169F, 167F), // LL
			SkewCorners(162F, 88F, // UL
					223F, 86F, // UR
					225F, 165F, // LR
					165F, 166F), // LL
			SkewCorners(157F, 87F, // UL
					218F, 85F, // UR
					221F, 165F, // LR
					159F, 166F), // LL
			SkewCorners(149F, 87F, // UL
					212F, 85F, // UR
					215F, 167F, // LR
					151F, 167F), // LL
			SkewCorners(140F, 87F, // UL
					203F, 86F, // UR
					203F, 170F, // LR
					140F, 169F), // LL
			SkewCorners(133F, 88F, // UL
					193F, 88F, // UR
					190F, 173F, // LR
					129F, 170F), // LL
			SkewCorners(129F, 90F, // UL
					190F, 90F, // UR
					186F, 177F, // LR
					124F, 173F), // LL
			SkewCorners(127F, 92F, // UL
					191F, 93F, // UR
					187F, 181F, // LR
					122F, 176F), // LL
			SkewCorners(129F, 96F, // UL
					192F, 99F, // UR
					185F, 187F, // LR
					122F, 179F), // LL
			SkewCorners(132F, 97F, // UL
					195F, 101F, // UR
					189F, 188F, // LR
					126F, 180F), // LL
			SkewCorners(134F, 96F, // UL
					197F, 100F, // UR
					192F, 188F, // LR
					128F, 180F), // LL
			SkewCorners(138F, 97F, // UL
					201F, 101F, // UR
					195F, 188F, // LR
					133F, 180F), // LL
			SkewCorners(142F, 97F, // UL
					206F, 101F, // UR
					200F, 188F, // LR
					137F, 181F), // LL
			SkewCorners(144F, 98F, // UL
					209F, 101F, // UR
					204F, 189F, // LR
					139F, 182F), // LL
			SkewCorners(145F, 98F, // UL
					209F, 102F, // UR
					204F, 190F, // LR
					140F, 182F), // LL
			SkewCorners(146F, 99F, // UL
					210F, 102F, // UR
					204F, 190F, // LR
					140F, 183F), // LL
			SkewCorners(146F, 99F, // UL
					210F, 103F, // UR
					205F, 191F, // LR
					141F, 183F), // LL
			SkewCorners(146F, 98F, // UL
					210F, 102F, // UR
					204F, 190F, // LR
					140F, 182F), // LL
			SkewCorners(145F, 98F, // UL
					209F, 102F, // UR
					202F, 190F, // LR
					138F, 182F), // LL
			SkewCorners(140F, 97F, // UL
					203F, 102F, // UR
					196F, 190F, // LR
					132F, 181F), // LL
			SkewCorners(130F, 96F, // UL
					191F, 102F, // UR
					182F, 190F, // LR
					122F, 178F), // LL
			SkewCorners(119F, 95F, // UL
					177F, 103F, // UR
					166F, 190F, // LR
					108F, 177F), // LL
			SkewCorners(109F, 95F, // UL
					164F, 102F, // UR
					153F, 190F, // LR
					99F, 176F), // LL
			SkewCorners(99F, 95F, // UL
					148F, 102F, // UR
					135F, 189F, // LR
					88F, 175F), // LL
			SkewCorners(90F, 94F, // UL
					132F, 102F, // UR
					118F, 189F, // LR
					77F, 174F), // LL
			SkewCorners(83F, 93F, // UL
					126F, 102F, // UR
					112F, 189F, // LR
					71F, 174F), // LL
			SkewCorners(81F, 95F, // UL
					126F, 105F, // UR
					112F, 192F, // LR
					70F, 176F), // LL
			SkewCorners(86F, 96F, // UL
					127F, 108F, // UR
					114F, 195F, // LR
					75F, 177F), // LL
			SkewCorners(89F, 98F, // UL
					128F, 108F, // UR
					116F, 197F, // LR
					77F, 179F), // LL
			SkewCorners(88F, 98F, // UL
					130F, 108F, // UR
					118F, 198F, // LR
					76F, 181F), // LL
			SkewCorners(87F, 99F, // UL
					130F, 109F, // UR
					118F, 201F, // LR
					76F, 183F), // LL
			SkewCorners(88F, 98F, // UL
					132F, 109F, // UR
					119F, 202F, // LR
					77F, 184F), // LL
			SkewCorners(88F, 97F, // UL
					133F, 108F, // UR
					121F, 203F, // LR
					77F, 184F), // LL
			SkewCorners(88F, 97F, // UL
					134F, 108F, // UR
					121F, 204F, // LR
					76F, 185F), // LL
			SkewCorners(87F, 98F, // UL
					134F, 109F, // UR
					120F, 207F, // LR
					75F, 188F), // LL
			SkewCorners(86F, 99F, // UL
					134F, 110F, // UR
					120F, 209F, // LR
					74F, 190F), // LL
			SkewCorners(85F, 99F, // UL
					133F, 110F, // UR
					119F, 211F, // LR
					72F, 191F), // LL
			SkewCorners(83F, 99F, // UL
					131F, 111F, // UR
					117F, 212F, // LR
					70F, 193F), // LL
			SkewCorners(82F, 99F, // UL
					131F, 111F, // UR
					117F, 213F, // LR
					69F, 194F), // LL
			SkewCorners(81F, 100F, // UL
					131F, 111F, // UR
					117F, 215F, // LR
					68F, 195F), // LL
			SkewCorners(84F, 100F, // UL
					134F, 112F, // UR
					119F, 216F, // LR
					70F, 196F), // LL
			SkewCorners(99F, 99F, // UL
					143F, 119F, // UR
					125F, 220F, // LR
					83F, 193F), // LL
			SkewCorners(131F, 98F, // UL
					149F, 128F, // UR
					125F, 220F, // LR
					110F, 182F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F) // LL

	)

	val frames2 = listOf(
			SkewCorners(95F, 76F, // UL
					154F, 93F, // UR
					133F, 168F, // LR
					73F, 151F), // LL
			SkewCorners(102F, 83F, // UL
					161F, 93F, // UR
					149F, 169F, // LR
					90F, 163F), // LL
			SkewCorners(116F, 91F, // UL
					167F, 95F, // UR
					161F, 172F, // LR
					109F, 173F), // LL
			SkewCorners(124F, 97F, // UL
					171F, 98F, // UR
					170F, 176F, // LR
					123F, 180F), // LL
			SkewCorners(123F, 101F, // UL
					173F, 99F, // UR
					176F, 177F, // LR
					126F, 184F), // LL
			SkewCorners(122F, 103F, // UL
					170F, 99F, // UR
					175F, 177F, // LR
					127F, 186F), // LL
			SkewCorners(122F, 101F, // UL
					166F, 97F, // UR
					171F, 175F, // LR
					127F, 184F), // LL
			SkewCorners(123F, 100F, // UL
					166F, 96F, // UR
					170F, 174F, // LR
					127F, 182F), // LL
			SkewCorners(122F, 99F, // UL
					167F, 96F, // UR
					169F, 174F, // LR
					125F, 181F), // LL
			SkewCorners(119F, 98F, // UL
					165F, 96F, // UR
					167F, 174F, // LR
					122F, 182F), // LL
			SkewCorners(118F, 99F, // UL
					164F, 96F, // UR
					166F, 174F, // LR
					121F, 182F), // LL
			SkewCorners(118F, 98F, // UL
					164F, 96F, // UR
					167F, 174F, // LR
					121F, 182F), // LL
			SkewCorners(118F, 97F, // UL
					163F, 95F, // UR
					166F, 172F, // LR
					120F, 180F), // LL
			SkewCorners(117F, 96F, // UL
					163F, 94F, // UR
					165F, 172F, // LR
					120F, 179F), // LL
			SkewCorners(116F, 95F, // UL
					163F, 93F, // UR
					165F, 172F, // LR
					119F, 179F), // LL
			SkewCorners(115F, 95F, // UL
					162F, 93F, // UR
					164F, 172F, // LR
					118F, 179F), // LL
			SkewCorners(115F, 95F, // UL
					162F, 93F, // UR
					164F, 172F, // LR
					118F, 179F), // LL
			SkewCorners(115F, 95F, // UL
					162F, 93F, // UR
					165F, 172F, // LR
					118F, 179F), // LL
			SkewCorners(115F, 93F, // UL
					162F, 92F, // UR
					165F, 170F, // LR
					118F, 177F), // LL
			SkewCorners(113F, 92F, // UL
					160F, 90F, // UR
					163F, 168F, // LR
					116F, 175F), // LL
			SkewCorners(108F, 90F, // UL
					156F, 89F, // UR
					159F, 167F, // LR
					110F, 174F), // LL
			SkewCorners(98F, 88F, // UL
					151F, 87F, // UR
					153F, 167F, // LR
					100F, 172F), // LL
			SkewCorners(85F, 87F, // UL
					144F, 87F, // UR
					146F, 168F, // LR
					86F, 172F), // LL
			SkewCorners(73F, 85F, // UL
					135F, 87F, // UR
					135F, 169F, // LR
					72F, 170F), // LL
			SkewCorners(63F, 83F, // UL
					127F, 87F, // UR
					124F, 170F, // LR
					59F, 169F), // LL
			SkewCorners(57F, 84F, // UL
					123F, 90F, // UR
					119F, 173F, // LR
					51F, 171F), // LL
			SkewCorners(54F, 87F, // UL
					120F, 91F, // UR
					116F, 176F, // LR
					49F, 172F), // LL
			SkewCorners(56F, 89F, // UL
					122F, 95F, // UR
					115F, 179F, // LR
					49F, 175F), // LL
			SkewCorners(59F, 91F, // UL
					125F, 96F, // UR
					119F, 180F, // LR
					53F, 177F), // LL
			SkewCorners(61F, 91F, // UL
					127F, 96F, // UR
					122F, 180F, // LR
					56F, 177F), // LL
			SkewCorners(65F, 92F, // UL
					131F, 96F, // UR
					126F, 180F, // LR
					60F, 178F), // LL
			SkewCorners(69F, 93F, // UL
					135F, 96F, // UR
					130F, 181F, // LR
					64F, 178F), // LL
			SkewCorners(72F, 94F, // UL
					138F, 97F, // UR
					133F, 181F, // LR
					67F, 179F), // LL
			SkewCorners(72F, 94F, // UL
					138F, 98F, // UR
					133F, 181F, // LR
					67F, 179F), // LL
			SkewCorners(73F, 94F, // UL
					139F, 98F, // UR
					134F, 182F, // LR
					67F, 180F), // LL
			SkewCorners(73F, 94F, // UL
					140F, 99F, // UR
					134F, 182F, // LR
					68F, 180F), // LL
			SkewCorners(73F, 93F, // UL
					139F, 97F, // UR
					134F, 181F, // LR
					68F, 179F), // LL
			SkewCorners(72F, 93F, // UL
					138F, 97F, // UR
					132F, 181F, // LR
					66F, 178F), // LL
			SkewCorners(67F, 91F, // UL
					133F, 96F, // UR
					126F, 180F, // LR
					60F, 176F), // LL
			SkewCorners(58F, 89F, // UL
					124F, 95F, // UR
					116F, 178F, // LR
					50F, 174F), // LL
			SkewCorners(48F, 88F, // UL
					113F, 95F, // UR
					104F, 176F, // LR
					40F, 170F), // LL
			SkewCorners(40F, 87F, // UL
					104F, 94F, // UR
					94F, 175F, // LR
					31F, 168F), // LL
			SkewCorners(33F, 85F, // UL
					94F, 93F, // UR
					83F, 174F, // LR
					22F, 164F), // LL
			SkewCorners(26F, 83F, // UL
					85F, 93F, // UR
					73F, 173F, // LR
					16F, 161F), // LL
			SkewCorners(23F, 84F, // UL
					78F, 93F, // UR
					67F, 173F, // LR
					13F, 161F), // LL
			SkewCorners(23F, 85F, // UL
					76F, 94F, // UR
					65F, 174F, // LR
					13F, 162F), // LL
			SkewCorners(25F, 86F, // UL
					81F, 95F, // UR
					70F, 176F, // LR
					15F, 164F), // LL
			SkewCorners(26F, 87F, // UL
					83F, 97F, // UR
					72F, 178F, // LR
					16F, 166F), // LL
			SkewCorners(25F, 88F, // UL
					81F, 97F, // UR
					71F, 179F, // LR
					15F, 167F), // LL
			SkewCorners(23F, 88F, // UL
					81F, 98F, // UR
					71F, 181F, // LR
					13F, 169F), // LL
			SkewCorners(23F, 88F, // UL
					82F, 97F, // UR
					72F, 182F, // LR
					13F, 170F), // LL
			SkewCorners(22F, 86F, // UL
					82F, 96F, // UR
					71F, 182F, // LR
					12F, 170F), // LL
			SkewCorners(20F, 86F, // UL
					82F, 96F, // UR
					71F, 184F, // LR
					10F, 171F), // LL
			SkewCorners(18F, 86F, // UL
					81F, 96F, // UR
					69F, 186F, // LR
					7F, 174F), // LL
			SkewCorners(16F, 87F, // UL
					80F, 97F, // UR
					68F, 188F, // LR
					5F, 176F), // LL
			SkewCorners(13F, 87F, // UL
					78F, 97F, // UR
					66F, 189F, // LR
					2F, 177F), // LL
			SkewCorners(10F, 87F, // UL
					76F, 98F, // UR
					64F, 191F, // LR
					0F, 178F), // LL
			SkewCorners(8F, 87F, // UL
					74F, 98F, // UR
					63F, 192F, // LR
					0F, 180F), // LL
			SkewCorners(6F, 88F, // UL
					73F, 99F, // UR
					62F, 194F, // LR
					0F, 182F), // LL
			SkewCorners(7F, 87F, // UL
					77F, 99F, // UR
					64F, 194F, // LR
					0F, 182F), // LL
			SkewCorners(20F, 83F, // UL
					94F, 97F, // UR
					80F, 190F, // LR
					9F, 175F), // LL
			SkewCorners(50F, 82F, // UL
					128F, 95F, // UR
					107F, 179F, // LR
					37F, 168F), // LL
			SkewCorners(88F, 93F, // UL
					160F, 98F, // UR
					132F, 169F, // LR
					66F, 168F), // LL
			SkewCorners(121F, 111F, // UL
					183F, 107F, // UR
					136F, 168F, // LR
					89F, 175F), // LL
			SkewCorners(138F, 126F, // UL
					195F, 113F, // UR
					135F, 176F, // LR
					103F, 183F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F), // LL
			SkewCorners(0F, 0F, // UL
					0F, 0F, // UR
					0F, 0F, // LR
					0F, 0F) // LL
	)
}