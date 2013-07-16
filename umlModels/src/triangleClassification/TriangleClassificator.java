package triangleClassification;


public class TriangleClassificator {

	public TriangleClassificator() {
		classification = TriangleClassification.unknown;
		w = 0;
		x = 0;
		y = 0;
		z = 0;
	}
	
	public void handleEvent(Object... in_colObject) {
		if(in_colObject.length > 0) {
			String sEventName = (String)in_colObject[0];
			

			if(sEventName.equals("classifyTriangle")) {
				x = (Integer)in_colObject[1];
				y = (Integer)in_colObject[2];
				z = (Integer)in_colObject[3];
				
				if(x > 0 && y > 0 && z > 0 &&
						(x < y + z) && (y < x + z) && (z < x + y)) {
					if(x == y || y == z || z == x) {
						// isosceles
						classification = TriangleClassification.isosceles;
						if(x == y && y == z) {
							// equilateral
							classification = TriangleClassification.equilateral;							
						}
					} else {
						// scalene
						classification = TriangleClassification.scalene;
					}
				} else {
					// illegal
					classification = TriangleClassification.illegal;
				}
			}
		}
	}

	public TriangleClassification classification;
	public Integer w;
	public Integer x;
	public Integer y;
	public Integer z;
}
