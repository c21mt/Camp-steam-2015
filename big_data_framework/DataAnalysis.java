public class DataAnalysis{

    public static void main(String [] args){
        ActorDatabase database = new ActorDatabase();


	int j=0;
	while(j<=database.length() -2){
	int i=0;
	while(i<= database.length() -2){
		Actor merp = database.get(i);
		Actor lerp = database.get(i+1);
		int merpMovies=merp.getNumberOfMovies();
		int lerpMovies= lerp.getNumberOfMovies();
		if(merpNumberOfMovies<lerpNumberOfMovies){
			//SWAP FUNCTION
			Actor temp = merp;
			database.set(i, lerp);
			database.set(i+1, temp);		
		}
	i=i+1;

	} /* end i while */
	
	j=j+1;
	}/*end j while*/
        System.out.print();

   }
