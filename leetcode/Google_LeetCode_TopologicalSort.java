package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Google_LeetCode_TopologicalSort {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps)
    {
        JobGraph jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph = new JobGraph(jobs);

        for(Integer[] dep : deps) {
            jobGraph.addDep(dep[0], dep[1]);
        }

        return jobGraph;
    }

    public static List<Integer> getOrderedJobs(JobGraph jobGraph) {
        List<Integer> orderedJobNodes = new ArrayList<>();
        List<JobNode> jobNodesWithNoPrereqs = new ArrayList<>();

        for(JobNode jobNode : jobGraph.nodes) {
            if (jobNode.numOfPrepreqs == 0) {
                jobNodesWithNoPrereqs.add(jobNode);
            }
        }

        while (jobNodesWithNoPrereqs.size() > 0) {
            JobNode node = jobNodesWithNoPrereqs.get(jobNodesWithNoPrereqs.size() - 1);
            jobNodesWithNoPrereqs.remove(jobNodesWithNoPrereqs.size() - 1);
            orderedJobNodes.add(node.job);
            removeDeps(node, jobNodesWithNoPrereqs);
        }

        boolean graphHasEdge = false;
        for(JobNode node : jobGraph.nodes) {
            if (node.numOfPrepreqs > 0) {
                graphHasEdge = true;
                break;
            }
        }

        return graphHasEdge ? new ArrayList<>() : orderedJobNodes;
    }

    public static void removeDeps(JobNode node, List<JobNode> nodesWithNoPrereqs) {
        while (node.deps.size() > 0) {
            JobNode dep = node.deps.get(node.deps.size() - 1);
            node.deps.remove(node.deps.size() - 1);
            dep.numOfPrepreqs--;
            if (dep.numOfPrepreqs == 0) {
                nodesWithNoPrereqs.add(dep);
            }
        }
    }

    static class JobGraph {
        private List<JobNode> nodes;
        private Map<Integer, JobNode> graph;

        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<>();
            graph = new HashMap<>();
            for(int job : jobs) {
                addJobNode(job);
            }
        }

        private void addJobNode(int job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }

        public JobNode getJobNode(int job) {
            if (!graph.containsKey(job)) {
                addJobNode(job);
            }

            return graph.get(job);
        }

        public void addDep(int job, int dep) {
            JobNode jobNode = getJobNode(job);
            JobNode depNode = getJobNode(dep);
            jobNode.deps.add(depNode);
            depNode.numOfPrepreqs++;
        }
    }

    static class JobNode {
        private int job;
        private List<JobNode> deps;
        private int numOfPrepreqs;
        
        public JobNode(int job) {
            this.job = job;
            deps = new ArrayList<>();
            numOfPrepreqs = 0;
        }
    }
}