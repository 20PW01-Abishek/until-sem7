% N QUEENS PROBLEM
function 
while 1
    chess=input('Size of Chessboard (Number of Queens): ');
    if chess <4
        disp('Board must be minimum size of 4!');
         
    end
    Chessboard(chess);
    DR=[1 1]; %Down-right
    DL=[-1 1]; %Down-left
    UR=[1 -1]; %Up-right
    UL=[-1 -1]; %Up-left
    icon=char(9819);

    M=1;
    while M<2
        Restart=0;
        rows=1:chess;
        cols=1:chess;
        QR=zeros(1,chess); %Rows of queens
        QC=zeros(1,chess); %Columns of queens
        QP=zeros(chess,2); %Positions of queens

        %Loop for the placing of the queens
        for n=1:chess
            %Row placement
            xpos=randi(length(rows));
            QR(n)=rows(xpos);
            rows(rows==QR(n))=[]; %Removing the chosen column from future placements
            %Column placement
            ypos=randi(length(cols));
            QC(n)=cols(ypos);
            cols(cols==QC(n))=[]; %Removing the chosen row from future placements
        end

        QP(:,1)=QR; %Position array, x coordinates
        QP(:,2)=QC; %Position array, y coordinates

        %Loop for checking diagonals
        for N=1:chess
            for m=1:chess
                for c=1:chess
                    if QP(c,:)+N*DR==QP(m,:)| QP(c,:)+N*DL==QP(m,:)| QP(c,:)+N*UR==QP(m,:)| QP(c,:)+N*UL==QP(m,:) %#ok<OR2>
                        Restart=1;
                    end
                end
            end
        end

        if Restart==0
            M=2;
        end
    end

    text(QR,QC,icon,'Color',[0.522,0.376,0.702],'FontSize', 200/chess,'HorizontalAlignment','Center')
end