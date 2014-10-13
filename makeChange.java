public static int makeChange(int n, int denom){
	int next_demon = 0 ;
	switch(denom){
		case 25:
			next_demon = 10 ;
			break ;
		case 10:
			next_demon = 5 ;
			break ;
		case 5:
			next_demon = 1 ;
			break ;
		case 1: 
			return 1 ;			
	}
	int ways = 0 ;
	for (int i = 0; i*denom <= n;i++ ) {
		ways += makeChange(n - i*denom, next_demon) ;
	}
	return ways ;
}

System.out.writeln(makeChange(n, 25)) ;
