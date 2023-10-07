class Solution {
public: 
    bool f = false;
    double op = 1.0;
    void dfs(string s,string d,double lp,map<string,int> &vis,map<string,vector<pair<string,double>>> &adj){
        if(f) return;
        if(s==d){
            f =true;
            op *= lp;
            return;
        }
        vis[s] = 1;
        for(auto x : adj[s]){
            if(!vis[x.first]){
                dfs(x.first,d,x.second,vis,adj);
            }
        }
        if(f){
            op *= lp;
        }
    }
    vector<double> calcEquation(vector<vector<string>>& eqn, vector<double>& val, vector<vector<string>>& que){
        int n = eqn.size();
        set<string> st;
        map<string,vector<pair<string,double>>> adj;
        for(int i=0;i<n;i++){
            adj[eqn[i][0]].push_back({eqn[i][1],val[i]});
            adj[eqn[i][1]].push_back({eqn[i][0],((double)1.0/(1.0*val[i]))});
            st.insert(eqn[i][0]);
            st.insert(eqn[i][1]);
        }
        vector<double> fs;
        for(int i=0;i<que.size();i++){
            op = 1.0;
            if(que[i][0] == que[i][1]){
                if(st.find(que[i][0]) != st.end()) op=1.0;
                else op = -1.0;
            }
            else{
                map<string,int> vis;
                f = false;
                dfs(que[i][0],que[i][1],1.0,vis,adj);
                if(!f) op = -1.0;
            }
            fs.push_back(op);
            
        }
        
        return fs;
    }
};