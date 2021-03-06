package Graph;

public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;
	public CC(Graph G)
	{
		marked=new boolean[G.V()];
		id=new int[G.V()];
		for(int i=0;i<G.V();i++)
		{
			if(!marked[i])
			{
				dfs(G,i);
				count++;
			}
		}
	}
	private void dfs(Graph G,int v)
	{
		id[v]=count;
		marked[v]=true;
		for(int w:G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	public boolean connected(int v,int w)
	{
		return id[v]==id[w];
	}
	public int id(int v)
	{
		return id[v];
	}
	public int count()
	{
		return count;
	}
}
