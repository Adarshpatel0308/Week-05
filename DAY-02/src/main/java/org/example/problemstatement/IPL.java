package org.example.problemstatement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;

public class IPL {
        // Censorship rules
        private static String maskTeamName(String teamName) {
            if (teamName == null || teamName.isEmpty()) {
                return teamName;
            }
            String[] parts = teamName.split(" ");
            if (parts.length > 1) {
                return parts[0] + " ***";
            }
            return teamName;
        }

        private static String redactPlayerOfMatch(String playerName) {
            return "REDACTED";
        }

        // Process JSON data
        private static void processJsonFile(String inputFilePath, String outputFilePath) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            try {
                // Read JSON file
                JsonNode rootNode = objectMapper.readTree(new File(inputFilePath));

                // Process each match
                for (JsonNode matchNode : rootNode) {
                    ObjectNode matchObject = (ObjectNode) matchNode;

                    // Mask team names
                    String team1 = matchObject.get("team1").asText();
                    String team2 = matchObject.get("team2").asText();
                    matchObject.put("team1", maskTeamName(team1));
                    matchObject.put("team2", maskTeamName(team2));

                    // Mask team names in scores
                    ObjectNode scoreNode = (ObjectNode) matchObject.get("score");
                    scoreNode.put(maskTeamName(team1), scoreNode.get(team1).asInt());
                    scoreNode.put(maskTeamName(team2), scoreNode.get(team2).asInt());
                    scoreNode.remove(team1);
                    scoreNode.remove(team2);

                    // Redact player of the match
                    String playerOfMatch = matchObject.get("player_of_match").asText();
                    matchObject.put("player_of_match", redactPlayerOfMatch(playerOfMatch));
                }

                // Write censored JSON to output file
                objectMapper.writeValue(new File(outputFilePath), rootNode);
                System.out.println("Censored JSON written to: " + outputFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Process CSV data
        private static void processCsvFile(String inputFilePath, String outputFilePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        // Write header as-is
                        writer.write(line);
                        isHeader = false;
                    } else {
                        // Process each line
                        String[] fields = line.split(",");
                        fields[1] = maskTeamName(fields[1]); // Mask team1
                        fields[2] = maskTeamName(fields[2]); // Mask team2
                        fields[5] = maskTeamName(fields[5]); // Mask winner
                        fields[6] = redactPlayerOfMatch(fields[6]);

                        // Write censored line
                        writer.newLine();
                        writer.write(String.join(",", fields));
                    }
                }

                System.out.println("Censored CSV written to: " + outputFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            // Input and output file paths
            String jsonInputFilePath = "src/main/java/org/example/problemstatement/file1.json";
            String jsonOutputFilePath = "src/main/java/org/example/problemstatement/file1output.json";
            String csvInputFilePath = "src/main/java/org/example/problemstatement/file2.csv";
            String csvOutputFilePath = "src/main/java/org/example/problemstatement/file2output.csv";

            // Process JSON file
            processJsonFile(jsonInputFilePath, jsonOutputFilePath);

            // Process CSV file
            processCsvFile(csvInputFilePath, csvOutputFilePath);
        }
    }
